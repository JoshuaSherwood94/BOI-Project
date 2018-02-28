insert into customer (CustName,UserName,email,password) values('Sean McGee','sean_mcgee_1','sean.mcgee@qa.com','sean12345');
insert into customer (CustName,UserName,email,password) values('Naill Mullready','niall_mullready_1','n.mulready@qa.com','niall1234');
insert into customer (CustName,UserName,email,password) values('Joshua Sherwood','josh_sherwood_1','j.sherwood@qa.com','josh12345');
insert into customer (CustName,UserName,email,password) values('Connor Harney','connor_harney_1','c.harney@qa.com','connor12345');
insert into customer (CustName,UserName,email,password) values('NIcky Tsang','nicky_tsang_1','n.tsang@qa.com','nicky12345');



insert into account (Account_Desc,Account_type,idCustomer) values('Receipt Book Company','Business',1);
insert into account (Account_Desc,Account_type,idCustomer) values('Personal Account','Current',1);
insert into account (Account_Desc,Account_type,idCustomer) values('Holiday Fund','Saving',1);
insert into account (Account_Desc,Account_type,idCustomer) values('Joint Family Account','Current',2);
insert into account (Account_Desc,Account_type,idCustomer) values('Personal Account','Current',2);
insert into account (Account_Desc,Account_type,idCustomer) values('Home Mortgage Account','Mortgage',2);
insert into account (Account_Desc,Account_type,idCustomer) values('Personal Account','Current',3);
insert into account (Account_Desc,Account_type,idCustomer) values('Personal Account','Current',4);
insert into account (Account_Desc,Account_type,idCustomer) values('Car Loan','Loan',4);
insert into account (Account_Desc,Account_type,idCustomer) values('Personal Account','Current',5);




insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Payment QA Ltd', '2018-2-12',5000,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Paroll','2018-2-13',-8350,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Insurance','2018-2-14',-450,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Payment RBS','2018-2-15',4600,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Catering','2018-2-16',-567,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Expenses - Client Meet','2018-2-17',-438.55,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Payment Talk Talk','2018-2-18',4500,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('The Works','2018-2-19',-153.63,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Payment IBM','2018-2-20',3400,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Payment Voadfone','2018-2-20',2050,1);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Tesco','2018-2-12',-61.71,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Esso','2018-2-13',-30,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Nandos','2018-2-14',-50.8,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Costa','2018-2-14',-3.4,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Savings','2018-2-15',-200,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Aldi','2018-2-16',-20,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Rent','2018-2-17',-900,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Car Insurance','2018-2-18',-200,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Sole Trader','2018-2-18',-70,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Next','2018-2-20',-65,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Wages','2018-2-20',1989,2);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Monthly Savings','2017-09-15',200,3);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Monthly Savings','2017-10-15',200,3);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Monthly Savings','2017-11-15',200,3);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Monthly Savings','2017-12-15',200,3);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Monthly Savings','2018-01-15',200,3);
insert into transaction (Transaction_Name,Date,Amount,idAccount) values('Monthly Savings','2018-02-15',200,3);



INSERT INTO receipt(path,text,Location,Transaction_id) VALUES('not set','Expenses - Client Meet','The Alchemist, MediaCity',6);
INSERT INTO receipt(path,text,Location,Transaction_id)VALUES ('not set','Stationary','The Works, The Lowry',8);
INSERT INTO receipt(path,text,Location,Transaction_id) VALUES('not set','Weekly Shop','Tesco Salford Quays',11);
INSERT INTO receipt(path,text,Location,Transaction_id) VALUES('not set','Petrol','Esso, Ardwick Green',12);
INSERT INTO receipt(path,text,Location,Transaction_id) VALUES('not set','Date Night','Nandos, The Lowry',13);



insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Meal Platter',1,21.45,5);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Coleslaw',1,2.8,5);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Spicy Rice',2,2.7,5);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Creamy Mash',1,3,5);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Garlic Bread(s)',1,3.85,5);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Cara Viva',1,14.3,5);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Tesco 8 Pork Loin Steaks 1.08Kg',2,2.75,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Terrys Chocolate Orange Easter Egg 266G',3,4,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Andrex Toilet Tissue 9 Roll Quilts',1,3.5,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Comfort Blue Fabric Conditioner 85 Wash 3L',1,3,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Tesco British Semi Skimmed Milk 4 Pints',2,1.09,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Tesco Bananas Loose',6,0.2,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Redmere Farms White Potato 2.5Kg',2,2.18,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Tesco Beef Lean Steak Mince 500G 5% Fat',2,3.78,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Tesco Medium Free Range Eggs 12 Pack',2,1.75,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Tesco British Salted Block Butter 250G',3,1.6,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Tesco Smoked Back Bacon Rashers 300G',1,1.99,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Lynx AfricaDeodorant 200Ml',2,3.67,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Nivea Men Sensitive Shower Gel 250Ml',1,4.78,3);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('2018 British Heart FoundationDiary',7,4.6,2);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Mark-it 2018 Giant Year Planner',11,7.22,2);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Envelopes 90gsm White DL [Pack 500]',5,8.4,2);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('Unleaded Petrol',27.28,1.1,4);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('SMASHED AVOCADO & POACHED EGGS',2,9.5,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('SMOKED SALMON WITH SCRAMBLED EGGS',3,8.75,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('HALLOUMI & AVOCADO MUFFIN',2,8.75,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values ('BROCCOMOLE & HOUMOUS',3,6.5,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('FETA & PESTO FILO ROLLS',4,5.5,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('7OZ FILLET',5,25,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('MOROCCAN LAMB RUMP',3,17.5,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('TEMPRANILLO',2,25,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('BEETROOT RISOTTO',2,10,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('CHICKEN IN A BASKET',1,12.8,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('BAKED LEMON CHEESECAKE',4,7,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('CHOCOLATE FUDGE CAKE',4,6.25,1);
insert into RECEIPTITEMS (name, quantity ,price, receipt_id ) values('CINNAMON WAFFLES',4,5.25,1);
