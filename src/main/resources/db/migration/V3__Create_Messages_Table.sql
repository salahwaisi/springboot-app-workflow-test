CREATE TABLE IF NOT EXISTS messages
(
    id SERIAL NOT NULL PRIMARY KEY,
    fromUserId INT NOT NULL,
    threadId CHARACTER VARYING,
    message TEXT,
    timeStampSent TIMESTAMP
);

CREATE TABLE IF NOT EXISTS messageRecipients
(
    id SERIAL NOT NULL PRIMARY KEY,
    messageId INT NOT NULL,
    toUserId INT NOT NULL
);