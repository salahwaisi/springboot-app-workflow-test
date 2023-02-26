INSERT INTO messages (threadId, fromUserId, message, timeStampSent) VALUES ('1-2', 1, 'Hello, how are you doing? 😄', CURRENT_TIMESTAMP);
INSERT INTO messageRecipients (messageId, toUserId) VALUES(1, 2);
INSERT INTO messages (threadId, fromUserId, message, timeStampSent) VALUES ('1-2', 2, 'Hello, I am doing just fine! 😄', CURRENT_TIMESTAMP);
INSERT INTO messageRecipients (messageId, toUserId) VALUES(2, 1);

INSERT INTO messages (threadId, fromUserId, message, timeStampSent) VALUES ('1-2-3', 1, 'Hello, this is a group message!', CURRENT_TIMESTAMP);
INSERT INTO messageRecipients (messageId, toUserId) VALUES (3, 2);
INSERT INTO messageRecipients (messageId, toUserId) VALUES (3, 3);
INSERT INTO messages (threadId, fromUserId, message, timeStampSent) VALUES ('1-2-3', 2, 'Hello, cool!', CURRENT_TIMESTAMP);
INSERT INTO messageRecipients (messageId, toUserId) VALUES (4, 1);
INSERT INTO messageRecipients (messageId, toUserId) VALUES (4, 3);
INSERT INTO messages (threadId, fromUserId, message, timeStampSent) VALUES ('1-2-3', 3, 'Hello, this is awesome!', CURRENT_TIMESTAMP);
INSERT INTO messageRecipients (messageId, toUserId) VALUES (5, 1);
INSERT INTO messageRecipients (messageId, toUserId) VALUES (5, 2);