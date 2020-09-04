package com.salesmanager.shop.store.facade.product;

import com.salesmanager.shop.model.catalog.product.ReadableProduct;
import com.salesmanager.shop.store.controller.product.facade.ProductFacade;
import junit.framework.TestCase;
import org.junit.Test;

public class ProductFacadeImplTest extends TestCase {

    private ProductFacade productFacade = new ProductFacadeImpl();

    @Test
    public void testCanBeRecommended() {
        // Let create some sample products, and test wheter they are discounted at least 20% or not
        ReadableProduct readableProduct1 = new ReadableProduct();
        readableProduct1.setOriginalPrice("$1000");
        readableProduct1.setFinalPrice("$700");
        readableProduct1.setDiscounted(true);
        try{
            assertTrue(productFacade.canBeRecommended(readableProduct1, "20"));
        }catch(Exception e){

        }

        ReadableProduct readableProduct2 = new ReadableProduct();
        readableProduct2.setOriginalPrice("$1000");
        readableProduct2.setFinalPrice("$950");
        readableProduct2.setDiscounted(true);
        try{
            assertFalse(productFacade.canBeRecommended(readableProduct2, "20"));
        }catch(Exception e){

        }

        ReadableProduct readableProduct3 = new ReadableProduct();
        readableProduct3.setOriginalPrice("$1000");
        readableProduct3.setFinalPrice("$550");
        readableProduct3.setDiscounted(false);
        try{
            assertFalse(productFacade.canBeRecommended(readableProduct3, "20"));
        }catch(Exception e){

        }
    }
}