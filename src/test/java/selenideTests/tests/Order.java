package selenideTests.tests;


import io.qameta.allure.Feature;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import selenideTests.common.TestBase;
import selenideTests.pages.AuthPage;
import selenideTests.pages.CartPage;
import selenideTests.pages.OrderPage;

@Feature("Оформление заказа")
@Tag("Order")
public class Order extends TestBase {

    //Тест оформления заказа самовывозом
    @Test
    public void orderSelfDelivery() {
        OrderPage orderPage = new OrderPage();
        CartPage cartPage = new CartPage();
        AuthPage authPage = new AuthPage();

        openBase();

        cartPage.goToProduct()
                .addProductToCart()
                .gotoBasket();

        orderPage.makeOrder();
        getAuthPage(authPage);

        orderPage
                .chooseSelfDeliveryMethod()
                .setSelfDeliveryPoint()
                .selectRecipientSelf()
                .choosePaymentMethodByCard()
                .makeOrder()
                .cancelPayment();
    }
}
