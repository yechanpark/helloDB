package kr.ac.hansung.spring.csemall;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("kr/ac/hansung/spring/csemall/beans/beans.xml");

		OfferDAO offerDAO = (OfferDAO) context.getBean("offerDAO");
		System.out.println("The record count is " + offerDAO.getRowCount());
		
		/* Select */
		List<Offer> offerList = offerDAO.getOffers();
		
		for(Offer offer: offerList){
			System.out.println(offer);
		}
		
		/* Insert */
		Offer offer = new Offer("nykim", "nykim@hansung.ac.kr", "an instructor of spring framework");
		if (offerDAO.insert(offer)) {
			System.out.println("Object is inserted successfully");
		}
		else {
			System.out.println("Object insertion failed");
		}
		
		/* Insert & Update */
		offer = offerDAO.getOffer("nykim");
		System.out.println(offer);

		offer.setName("Namyun Kim");
		if( offerDAO.update(offer) )
			System.out.println("update with object: " + offer);
		else System.out.println("Cannot update an object");
		
		
		/* Delete */
		if( offerDAO.delete(offer.getId()) )
			System.out.println("Object is deleted");
		else
			System.out.println("cannot delete Object");
		
		context.close();
	}

}