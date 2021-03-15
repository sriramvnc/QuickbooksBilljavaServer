package com.intuit.developer.sampleapp.crud.helper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.intuit.ipp.data.*;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.util.DateUtils;

/**
 * @author dderose
 *
 */
public final class BillHelper {

	private BillHelper() {
		
	}

	public static Bill getBillFields(DataService service) throws FMSException, ParseException {

		Bill bill = new Bill();

		Vendor vendor = VendorHelper.getVendor(service);
		bill.setVendorRef(VendorHelper.getVendorRef(vendor));

		Account liabilityAccount = AccountHelper.getLiabilityBankAccount(service);
		bill.setAPAccountRef(AccountHelper.getAccountRef(liabilityAccount));
         /*

           <element name="Id" type="{http://schema.intuit.com/finance/v3}id" minOccurs="0"/>
           <element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
           <element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
           <element name="Amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
           <element name="Received" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
           <element name="LinkedTxn" type="{http://schema.intuit.com/finance/v3}LinkedTxn" maxOccurs="unbounded" minOccurs="0"/>
           <element name="DetailType" type="{http://schema.intuit.com/finance/v3}LineDetailTypeEnum" minOccurs="0"/>
           <choice minOccurs="0">
             <element name="PaymentLineDetail" type="{http://schema.intuit.com/finance/v3}PaymentLineDetail"/>
             <element name="DiscountLineDetail" type="{http://schema.intuit.com/finance/v3}DiscountLineDetail"/>
             <element name="TaxLineDetail" type="{http://schema.intuit.com/finance/v3}TaxLineDetail"/>
             <element name="SalesItemLineDetail" type="{http://schema.intuit.com/finance/v3}SalesItemLineDetail"/>
             <element name="DescriptionLineDetail" type="{http://schema.intuit.com/finance/v3}DescriptionLineDetail"/>
             <element name="ItemBasedExpenseLineDetail" type="{http://schema.intuit.com/finance/v3}ItemBasedExpenseLineDetail"/>
             <element name="AccountBasedExpenseLineDetail" type="{http://schema.intuit.com/finance/v3}AccountBasedExpenseLineDetail"/>
             <element name="ReimburseLineDetail" type="{http://schema.intuit.com/finance/v3}ReimburseLineDetail"/>
             <element name="DepositLineDetail" type="{http://schema.intuit.com/finance/v3}DepositLineDetail"/>
             <element name="PurchaseOrderItemLineDetail" type="{http://schema.intuit.com/finance/v3}PurchaseOrderItemLineDetail"/>
             <element name="SalesOrderItemLineDetail" type="{http://schema.intuit.com/finance/v3}SalesOrderItemLineDetail"/>
             <element name="ItemReceiptLineDetail" type="{http://schema.intuit.com/finance/v3}ItemReceiptLineDetail"/>
             <element name="JournalEntryLineDetail" type="{http://schema.intuit.com/finance/v3}JournalEntryLineDetail"/>
             <element name="GroupLineDetail" type="{http://schema.intuit.com/finance/v3}GroupLineDetail"/>
             <element name="SubTotalLineDetail" type="{http://schema.intuit.com/finance/v3}SubTotalLineDetail"/>
             <element name="TDSLineDetail" type="{http://schema.intuit.com/finance/v3}TDSLineDetail"/>
           </choice>
           <element name="CustomField" type="{http://schema.intuit.com/finance/v3}CustomField" maxOccurs="unbounded" minOccurs="0"/>
           <element name="LineEx" type="{http://schema.intuit.com/finance/v3}IntuitAnyType" minOccurs="0"/>

*/

		/*Line line1 = new Line();
		line1.setAmount(new BigDecimal("21128.00"));
		line1.setDetailType(LineDetailTypeEnum.ACCOUNT_BASED_EXPENSE_LINE_DETAIL);
		AccountBasedExpenseLineDetail detail = new AccountBasedExpenseLineDetail();
		Account account = AccountHelper.getExpenseBankAccount(service);
		ReferenceType expenseAccountRef = AccountHelper.getAccountRef(account);
		detail.setAccountRef(expenseAccountRef);
		line1.setAccountBasedExpenseLineDetail(detail);
		List<Line> lines1 = new ArrayList<Line>();
		lines1.add(line1);
		bill.setLine(lines1);*/

		Line line1 = new Line();
		line1.setAmount(new BigDecimal("198.00"));
		line1.setDetailType(LineDetailTypeEnum.ITEM_BASED_EXPENSE_LINE_DETAIL);
		ItemBasedExpenseLineDetail detail = new ItemBasedExpenseLineDetail();
		//Account account = AccountHelper.getExpenseBankAccount(service);
		//ReferenceType expenseAccountRef = AccountHelper.getAccountRef(account);
		//detail.setAccountRef(expenseAccountRef);
		//line1.setAccountBasedExpenseLineDetail(detail);
		List<Line> lines1 = new ArrayList<Line>();
		lines1.add(line1);
		bill.setLine(lines1);

  // adding items, quantity

		/*Line line3 = new Line();
		line3.setLineNum(new BigInteger("1"));
		line3.setAmount(new BigDecimal("300.00"));
		line3.setDetailType(LineDetailTypeEnum.SALES_ITEM_LINE_DETAIL);

		SalesItemLineDetail salesItemLineDetail1 = new SalesItemLineDetail();
		Item item = ItemHelper.getItem(service);
		salesItemLineDetail1.setItemRef(ItemHelper.getItemRef(item));

		ReferenceType taxCodeRef1 = new ReferenceType();
		taxCodeRef1.setValue("NON");
		salesItemLineDetail1.setTaxCodeRef(taxCodeRef1);
		line3.setSalesItemLineDetail(salesItemLineDetail1);

		Line line2 = new Line();
		line2.setAmount(new BigDecimal("300.00"));
		line2.setDetailType(LineDetailTypeEnum.SUB_TOTAL_LINE_DETAIL);
		line2.setSubTotalLineDetail(new SubTotalLineDetail());

		List<Line> lines3 = new ArrayList<Line>();
		lines3.add(line3);
		lines3.add(line2);
		bill.setLine(lines3);
       */

		//lines1.add(line1);

     /*
     "PayerRef" type="{http://schema.intuit.com/finance/v3}ReferenceType" minOccurs="0"/>
           <element name="SalesTermRef" type="{http://schema.intuit.com/finance/v3}ReferenceType" minOccurs="0"/>
           <element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
           <element name="RemitToAddr" type="{http://schema.intuit.com/finance/v3}PhysicalAddress" minOccurs="0"/>
           <element name="ShipAddr" type="{http://schema.intuit.com/finance/v3}PhysicalAddress" minOccurs="0"/>
           <element name="VendorAddr" type="{http://schema.intuit.com/finance/v3}PhysicalAddress" minOccurs="0"/>
           <element name="Balance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
           <element name="HomeBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
           <element name="BillEx" type="{http://schema.intuit.com/finance/v3}IntuitAnyType" minOccurs="0"/>
           <element name="LessCIS" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
           <element name="IncludeInAnnualTPAR" type="{http://
      */



		bill.setBillEmail(Email.getEmailAddress());
		bill.setDomain("QBO");


		bill.setGlobalTaxCalculation(GlobalTaxCalculationEnum.NOT_APPLICABLE);

		bill.setRemitToAddr(Address.getPhysicalAddress());
       // bill.set
		bill.setReplyEmail(Email.getEmailAddress());

		bill.setShipAddr(Address.getPhysicalAddress());

		bill.setTotalAmt(new BigDecimal("900.00"));
		bill.setTxnDate(DateUtils.getCurrentDateTime());
		bill.setDueDate(DateUtils.getDateWithNextDays(60));

		return bill;
	}

	public static Bill getBill(DataService service) throws FMSException, ParseException {
		List<Bill> bills = (List<Bill>) service.findAll(new Bill());
		if (!bills.isEmpty()) {
			return bills.get(0);
		}
		return createBill(service);
	}

	private static Bill createBill(DataService service) throws FMSException, ParseException {
		return service.add(getBillFields(service));
	}
	
	public static BillPayment getBillPaymentFields(DataService service) throws FMSException, ParseException {
		BillPayment billPayment = new BillPayment();

		billPayment.setTxnDate(DateUtils.getCurrentDateTime());
		
		billPayment.setPrivateNote("Check billPayment");

		Vendor vendor = VendorHelper.getVendor(service);
		billPayment.setVendorRef(VendorHelper.getVendorRef(vendor));
		
		Line line1 = new Line();
		line1.setAmount(new BigDecimal("30"));
		List<LinkedTxn> linkedTxnList1 = new ArrayList<LinkedTxn>();
		LinkedTxn linkedTxn1 = new LinkedTxn();
		Bill bill = getBill(service);
		linkedTxn1.setTxnId(bill.getId());
		linkedTxn1.setTxnType(TxnTypeEnum.BILL.value());
		linkedTxnList1.add(linkedTxn1);
		line1.setLinkedTxn(linkedTxnList1);
		
		List<Line> lineList = new ArrayList<Line>();
		lineList.add(line1);
		billPayment.setLine(lineList);

		BillPaymentCheck billPaymentCheck = new BillPaymentCheck();
		Account bankAccount = AccountHelper.getCheckBankAccount(service);
		billPaymentCheck.setBankAccountRef(AccountHelper.getAccountRef(bankAccount));
		
		billPaymentCheck.setCheckDetail(PaymentHelper.getCheckPayment());		

		billPaymentCheck.setPayeeAddr(Address.getPhysicalAddress());
		billPaymentCheck.setPrintStatus(PrintStatusEnum.NEED_TO_PRINT);
		
		billPayment.setCheckPayment(billPaymentCheck);
		billPayment.setPayType(BillPaymentTypeEnum.CHECK);
		billPayment.setTotalAmt(new BigDecimal("30"));
		return billPayment;
	}

}
