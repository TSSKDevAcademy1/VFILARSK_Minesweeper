package model;

import java.util.List;

public class InvoiceDao {
	
	public void saveInvoice(Invoice invoice){
		JpaHelper.beginTransaction();
		JpaHelper.getEntityManager().persist(invoice);
		JpaHelper.commitTransaction();
	}
	
	public void listAllInvoices(){
		JpaHelper.beginTransaction();
		List<Invoice> invoices = JpaHelper.getEntityManager().createQuery("select c from Invoice c", Invoice.class).getResultList();
		for(Invoice invoice :  invoices){
			System.out.println(invoice);
		}
	}
	
	
}
