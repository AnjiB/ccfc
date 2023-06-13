INSERT INTO CcInfo (id, ccNo, expDate) VALUES ('123','4532788397355156', '2025-03-31');
INSERT INTO CcInfo (id, ccNo, expDate) VALUES ('124', '4532788397355157', '2025-06-30');
INSERT INTO CcInfo (id, ccNo, expDate) VALUES ('125', '5468428372592078', '2025-03-31');
INSERT INTO CcInfo (id, ccNo, expDate) VALUES ('126', '5451705079204365', '2025-03-31');


INSERT INTO CcIssuerInfo (id, ccNo, issueDate, issuer) VALUES ('226', '4532788397355156', '2019-03-31', 'VISA');
INSERT INTO CcIssuerInfo (id, ccNo, issueDate, issuer) VALUES ('227', '4532788397355157', '2020-06-30', 'VISA');
INSERT INTO CcIssuerInfo (id, ccNo, issueDate, issuer) VALUES ('228', '5468428372592078', '2018-03-31', 'MASTER_CARD');
INSERT INTO CcIssuerInfo (id, ccNo, issueDate, issuer) VALUES ('229', '5451705079204365', '2023-03-31', 'MASTER_CARD');


INSERT INTO CcFraudScoreInfo (id, ccId, ccIssuerId, score) VALUES ('337', '123', '226', '700');
INSERT INTO CcFraudScoreInfo (id, ccId, ccIssuerId, score) VALUES ('338', '124', '227', '500');
INSERT INTO CcFraudScoreInfo (id, ccId, ccIssuerId, score) VALUES ('339', '125', '228', '300');
INSERT INTO CcFraudScoreInfo (id, ccId, ccIssuerId, score) VALUES ('340', '126', '229', '900');
