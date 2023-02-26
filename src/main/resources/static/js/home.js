document.selectedSender = null;
document.senderForm = {
    recipients: [],
    message: ''
};

/**
 * Fetches a complete list of users
 * 
 * @returns List of users
 */
async function fetchUsers() {
    var userList = [];
    
    await fetch('/api/users').then((result) => {
        if (result.ok === true) {
            return result.json();
        }
    }).then((results) => {
        if (results && results.length > 0) {
            for (var i = 0; i < results.length; i++) {
                userList.push(results[i]);
            }
        }
    });

    return userList;
}

async function fetchMessageThreads() {
    var messageList = [];

    await fetch('/api/messages/' + document.selectedSender).then((result) => {
        if (result.ok === true) {
            return result.json();
        }
    }).then((results) => {
        if (results && results.length > 0) {
            for (var i = 0; i < results.length; i++) {
                messageList.push(results[i]);
            }
        }
    });

    return messageList;
}

async function populateMessageThreads() {
    var messageThreadList = await fetchMessageThreads();

    var formattedMessageList = '';

    messageList.forEach((message) => {
        console.log("#looping through message", message)

        formattedMessageList += '<div class="message-thread-item">' +
            '<div class="message-thread-display-name"></div>' +
            '</div>';

        formattedMessageList += '<div class="message-item-container' + 
            ((message.from == document.selectedSender) ? ' message-item-from' : ' message-item-to') + 
            '"><div class="message-item">' +
            '<div class="message-item-date">' + message.dateTimeSent + '</div>' +
            '<div class="message-item-message">' + message.message + '</div>' +
            '</div></div>'
    });

    document.querySelector('.message-item-wrapper').innerHTML = formattedMessageList;
}

async function populateUsers() {
    var users = await fetchUsers();

    var formattedSenderList = '';
    
    users.forEach((user) => {
        formattedSenderList += ('<option value="' + user.id + '">' + user.firstName + " " + user.lastName + '</option>')
    });

    document.querySelector("#inp-sender-selector").innerHTML = '<option selected value="null">Select who you are</option>' + 
    formattedSenderList;
    document.querySelector("#inp-recipients-selector").innerHTML = formattedSenderList;
}

function onSenderChange() {
    var newSelectedSender = document.querySelector("#inp-sender-selector").value;
    
    console.log("## Changing sender to", newSelectedSender);
    document.selectedSender = newSelectedSender;

    document.querySelector('.no-sender-selected-message').style.display = 'none';
    document.querySelector('.no-messages').style.display = 'none';

    document.querySelector('#inp-message-content').focus();

    populateMessages();
}

function onRecipientsChange(recipientList) {
    document.senderForm.recipients = [];
    console.log("## onRecipientsChange, value:", recipientList);

    if (recipientList && recipientList.length > 0) {
        for (var i = 0; i < recipientList.length; i++ ){
            document.senderForm.recipients.push({
                id: recipientList[0].value
            });

        }
    }

    console.log("## onRecipientsChange, document.senderForm: ", document.senderForm);
}

function sendMessage() {
    var recipientList = [];
    var inpMessageTextArea = document.querySelector('#inp-message-content');
    var messageContent = inpMessageTextArea.value;
    
    console.log("## Sending message " + messageContent + "to ", recipientList);
    inpMessageTextArea.value = "";

    return false;
}

populateUsers();