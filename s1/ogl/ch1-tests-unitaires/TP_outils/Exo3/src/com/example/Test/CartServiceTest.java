package com.example.Test;

import com.example.dao.ICartDao;
import com.example.dao.IProductDao;
import com.example.model.Customer;
import com.example.model.Product;
import com.example.service.CartService;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CartServiceTest {
    @Test
    public void addProductToCart1() {
        /* cette méthode permet de tester la partie de la méthode addProductToCart
     dans le cas ou la quantité de produit<= quantité du Stock */

        /*création d'un produit*/
        Product produit=new Product("20201812","Téléphone prtable","Iphone 12",20, 2500000L);
        /*création d'un client*/
        Customer client=new Customer(1L,"Boucherir","Zineddine");
        IProductDao mockProductDao= Mockito.mock(IProductDao.class);
        ICartDao mockCardDao= Mockito.mock(ICartDao.class);
        /*on a supposé que la methode "addProductToCart" de l'interface non implémenté
         "ICardDao retourne True*/
        Mockito.when(mockCardDao.addProductToCart(produit,client)).thenReturn(true);
        /*on a supposé que la methode "getProductQte" de l'interface non implémenté
        "IProductDao retourne 100*/
        Mockito.when(mockProductDao.getProductQte(produit)).thenReturn(100);
        /*instanciation de la classe CartService*/
        CartService cartService=new CartService(mockProductDao,mockCardDao);
        assertTrue(cartService.addProductToCart(produit,client));
    }
    @Test
    public void addProductToCart2() {
        /* cette méthode permet de tester la partie de la méthode addProductToCart
     dans le cas ou la quantité de produit>quantité du Stock */
        Product produit=new Product("20201812","Téléphone prtable","Iphone 12",20, 2500000L);
        Customer client=new Customer(1L,"Bouidaine","Diaeddin");
        IProductDao mockProductDao= Mockito.mock(IProductDao.class);
        ICartDao mockCardDao= Mockito.mock(ICartDao.class);
        Mockito.when(mockCardDao.addProductToCart(produit,client)).thenReturn(true);
        /*on a supposé que la methode "getProductQte" de l'interface non implémenté
        "IProductDao retourne 10*/
        Mockito.when(mockProductDao.getProductQte(produit)).thenReturn(10);
        CartService cartService=new CartService(mockProductDao,mockCardDao);
        assertFalse(cartService.addProductToCart(produit,client));
    }
}