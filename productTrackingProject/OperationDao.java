package productTrackingProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nit.jdbcTask01.BookBo;

@Repository
public class OperationDao {

	private static final String QUERY_FOR_ALL_PRODUCT_DETAILS="select * from productInfo";
	private static final String QUERY_FOR_PRODUCT_PRICE="select Price from productInfo where productName=?";
	private static final String QUERY_FOR_INSER_PRODUCT="insert into productInfo (productId,productName,shippingadd,price,quantity,placeddate) values (?,?,?,?,?,?)";
	private static final String QUERY_FOR_DELETE_PRODUCT="delete from productInfo where productId=?";
	private static final String  QUERY_FOR_UPDATE_PRODUCT="update productInfo set shippingAdd=?,placeddate=? where productName=?";
	private static final String QUERY_FOR_PRODUCT_COUNT="select count(*) from productInfo";
	private static final String QUERY_FOR_PRODUCT_COUNT_USING_SHIPPINGADD="select count(*) from productInfo where shippingAdd=?";
	private static final String QUERY_FOR_PRODUCT_DETAILS_USING_ID="select productId,productName, shippingadd,price,quantity,placeddate from productinfo where productid=?";
	private JdbcTemplate template;
	
	@Autowired
	public OperationDao(JdbcTemplate template)
	{
		this.template=template;
	}
	
	
	public  int getProductPrice(String name)
	{ 
	  return template.queryForObject(QUERY_FOR_PRODUCT_PRICE, Integer.class, new Object[] {name});
	}
	
	public ProductDelivery getProductDetailsById(int id)
	{
		return template.queryForObject(QUERY_FOR_PRODUCT_DETAILS_USING_ID, new Object[] {id},(rs,row)->{
			ProductDelivery delivery=new ProductDelivery();
			  delivery.setProductId(rs.getInt(1));
			  delivery.setProductName(rs.getString(2));
			  delivery.setProductShippingAddress(rs.getString(3));
			  delivery.setProductPrice(rs.getInt(4));
			  delivery.setProductQuantity(rs.getInt(5));
			  delivery.setProductPlaceData(rs.getString(6));
			
			return delivery;
		});
	}
	
	public List<ProductDelivery> getAllProduct()
	{
		return template.query(QUERY_FOR_ALL_PRODUCT_DETAILS, (rs,row)->{
			ProductDelivery product=new ProductDelivery();
			product.setProductId(rs.getInt(1));
		    product.setProductName(rs.getString(2));
		    product.setProductShippingAddress(rs.getString(3));
		    product.setProductPrice(rs.getInt(4));
		    product.setProductQuantity(rs.getInt(5));
		    product.setProductPlaceData(rs.getString(6));
		 return product;
		});
		
	}
	
	
	public int insetProduct(ProductDelivery product)
	{
		return template.update(QUERY_FOR_INSER_PRODUCT,new Object[] {product.getProductId(),
				product.getProductName(),product.getProductShippingAddress(),product.getProductPrice(),
				product.getProductQuantity(), product.getProductPlaceData()});
	}
	
	public int deleteProduct(int productId)
	{
		return template.update(QUERY_FOR_DELETE_PRODUCT,new Object[] {productId});
	}
	
	public int updateProduct(String shippingAddress,String date,String name)
	{
		return template.update(QUERY_FOR_UPDATE_PRODUCT,new Object[] {shippingAddress,date,name});
	}
	
	public int getProductCount()
	{
		return template.queryForObject(QUERY_FOR_PRODUCT_COUNT, Integer.class);
	}
	
	public int getProductCountUsingShippingAdd(String address)
	{
		return template.update(QUERY_FOR_PRODUCT_COUNT_USING_SHIPPINGADD,new Object[] {address});
	}
	
	
}
