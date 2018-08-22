package jdbc;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

/**
 * Testing class for store front
 */
public class StoreFrontTest {
	StoreFront storefront = new StoreFront();
	OrderDetail orderDetail;
	Image image;

	@After
	public void close(){
		storefront.closeConnection();
	}
	
	@Test
	public void getOrderDetail1() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals(1,(storefront.getOrderDetail(1).get(0).getOrderId()));
		assertEquals(formatter.parse("2018-08-21"),(storefront.getOrderDetail(1).get(0).getOrderDate()));
		assertEquals(1, storefront.getOrderDetail(1).get(0).getOrderId());
		assertEquals(2000, storefront.getOrderDetail(1).get(0).getTotalAmount(),0);
	}
	
	@Test
	public void getOrderDetail2() {
		assertEquals(0, storefront.getOrderDetail(2).size());
	}
	
	@Test
	public void getCheckValidate() {
		assertTrue(storefront.validate(2));
	}

	@Test
	public void getCheckInvalidUser() {
		assertFalse(storefront.validate(442));
	}
	
	@Test
	public void testInsertImage() {

		List<Image> imageList = new ArrayList<Image>();
		imageList.add(new Image(1, "image1insert1.jpg"));
		imageList.add(new Image(2, "image1insert2.jpg"));
		imageList.add(new Image(3, "image1insert3.jpg"));
		imageList.add(new Image(4, "image1insert4.jpg"));

		assertEquals(4, storefront.insertImage(imageList));
	}

	@Test
	public void testUpdateProduct() {
		assertEquals(18, storefront.UpdateProduct());
	}
	
	@Test
	public void testNotUpdateProduct() {
		assertEquals(0, storefront.UpdateProduct());
	}
	
	@Test
	public void testSelectAndDispaly() {
		
		assertEquals(2,(storefront.selectAndDispaly().get(0).getCategoryId()));
		assertEquals("Clothing",(storefront.selectAndDispaly().get(0).getParentCategoryName()));
		assertEquals(3,(storefront.selectAndDispaly().get(0).getNoOfChild()));
		
		assertEquals(1,(storefront.selectAndDispaly().get(1).getCategoryId()));
		assertEquals("Electronic_Gadgets",(storefront.selectAndDispaly().get(1).getParentCategoryName()));
		assertEquals(3,(storefront.selectAndDispaly().get(1).getNoOfChild()));
		
		assertEquals(3,(storefront.selectAndDispaly().get(2).getCategoryId()));
		assertEquals("Footwear",(storefront.selectAndDispaly().get(2).getParentCategoryName()));
		assertEquals(2,(storefront.selectAndDispaly().get(2).getNoOfChild()));
		
	}
	
}
