package com.example.Test;

import com.example.dao.IOrderDao;
import com.example.dao.IPaymentDao;
import com.example.model.*;
import com.example.service.PaymentService;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.*;

import static org.junit.Assert.*;

public class PaymentServiceTest {

    @Test
    public void addPayment1() {
            /* cette méthode permet de tester la partie de la méthode addPayment
     dans le cas ou le prix de tout les prduits (la somme des prix*quantité) est
      égale au montant de l'ordre */
        /*la création de deux produits pour les ajouter à la liste des produits*/
        Product produit1=new Product("20201812","Iphone 12","Téléphone prtable",3, 2500000L);
        Product produit2=new Product("20201813","samsung","Télévision",2, 1000000L);
        List<Product> ListProduit=new ArrayList<>();
        ListProduit.add(produit1);
        ListProduit.add(produit2);
        /*création d'un client*/
        Customer client=new Customer(1L,"Boucherir","Zineddine");
        /*creation d'une cart*/
        Cart cart=new Cart(ListProduit,client);
        Date d1=new Date(2020,Calendar.DECEMBER,15);
        Date d2=new Date(2020,Calendar.DECEMBER,18);
        /*création d'un ordre*/
        Order order=new Order(1L,cart,d1);
        /*création d'un paiment*/
        Payment payment=new Payment(1L,order,9500000L,d2);
        IOrderDao mockOrderDao= Mockito.mock(IOrderDao.class);
        IPaymentDao mockPaymentDao= Mockito.mock(IPaymentDao.class);
        /*on a supposé que la methode "addPayment" de l'interface non implémenté
        "IPaymentDao retourne True*/
        Mockito.when(mockPaymentDao.addPayment(payment)).thenReturn(true);
        /*instanciation de la classe PaymentService */
        PaymentService paymentService=new PaymentService(mockOrderDao,mockPaymentDao);
        assertTrue(paymentService.addPayment(payment));
    }
    @Test
    public void addPayment2() {
         /* cette méthode permet de tester la partie de la méthode addPayment
     dans le cas ou le prix de tout les prduits (la somme des prix*quantité)
      n'égale pas le montant de l'ordre */
        Product produit1=new Product("20201814","Iphone 12","Téléphone prtable",3, 2500000L);
        Product produit2=new Product("20201815","samsung","Télévision",2, 1000000L);
        List<Product> ListProduit=new ArrayList<>();
        ListProduit.add(produit1);
        ListProduit.add(produit2);
        Customer client=new Customer(2L,"Boucherir","Zineddine");
        Cart cart=new Cart(ListProduit,client);
        Date d1=new Date(2020,Calendar.DECEMBER,15);
        Date d2=new Date(2020,Calendar.DECEMBER,18);
        Order order=new Order(2L,cart,d1);
        Payment payment=new Payment(2L,order,95000L,d2);
        IOrderDao mockOrderDao= Mockito.mock(IOrderDao.class);
        IPaymentDao mockPaymentDao= Mockito.mock(IPaymentDao.class);
        Mockito.when(mockPaymentDao.addPayment(payment)).thenReturn(true);
        PaymentService paymentService=new PaymentService(mockOrderDao,mockPaymentDao);
        assertFalse(paymentService.addPayment(payment));
    }
}