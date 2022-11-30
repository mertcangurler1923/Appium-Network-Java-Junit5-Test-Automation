package org.example;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class App extends BaseApp {
    By cookie= By.id("com.android.packageinstaller:id/permission_deny_button");
    By searchTextbox= By.id("mobi.appcent.network:id/ivSearch");
    By textTextbox=By.id("mobi.appcent.network:id/tetSearch");
    By discountPercent=By.xpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.ImageView");
    By discountMoney=By.id("mobi.appcent.network:id/tvProductDiscountPrice");
    By notDiscountMoney=By.id("mobi.appcent.network:id/tvProductActualPrice");
    By size=By.id("mobi.appcent.network:id/btSelectSize");
    By boxDiscountMoney=By.id("mobi.appcent.network:id/tv_actual_price");
    By boxNotDiscountMoney=By.id("mobi.appcent.network:id/tv_strikethrough_price");
    By boxSize=By.id("mobi.appcent.network:id/tv_size");
    By sizeSelect=By.xpath("//android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]");
    By addToCard=By.id("mobi.appcent.network:id/btAddToCart");
    By space=By.id("mobi.appcent.network:id/touch_outside");
    By box=By.id("mobi.appcent.network:id/ivBasket");
    By goOn=By.id("mobi.appcent.network:id/go_checkout");
    By mailBox=By.id("mobi.appcent.network:id/etUserEmail");
    By passwordBox=By.id("mobi.appcent.network:id/etPassword");
    By login=By.id("mobi.appcent.network:id/btnUserLogin");
    By notSaveMail=By.id("android:id/autofill_save_no");
    By back=By.id("mobi.appcent.network:id/ivStart");
    By boxTrash=By.id("mobi.appcent.network:id/pnl_remove_basket");
    By boxTrashYes=By.id("mobi.appcent.network:id/tv_delete_product");
    By subMenu=By.id("mobi.appcent.network:id/includeBottomSheet");
    By productCaption=By.id("mobi.appcent.network:id/rlToolBarBackground");

    Log log = new Log();
    public App(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public List<String> test() throws FileNotFoundException {
        clickIf(cookie);
        log.info("Cookie kapatıldı.");
        click(searchTextbox);
        inputEnter(textTextbox,"ceket");
        log.info("Textboxa ceket ürünü girildi.");
        click(discountPercent);
        log.info("Ürüne tıklanıldı.");
        click(size);
        click(sizeSelect);
        log.info("Beden seçildi.");
        click(addToCard);
        log.info("Sepete eklendi.");
        click(space);
        dragAndDropByCoordinates(444,1470,444,300);
        String sizeValue=getText(size);
        String discountMoneyValue=getText(discountMoney);
        String notDiscountMoneyValue=getText(notDiscountMoney);
        click(box);
        log.info("Sepete tıklanıldı.");
        String boxSizeValue=getText(boxSize);
        String boxDiscountMoneyValue=getText(boxDiscountMoney);
        String boxNotDiscountMoneyValue=getText(boxNotDiscountMoney);
        List<String> idPassword=csvRead();
        click(goOn);
        log.info("Devam et butonuna tıklanıldı.");
        input(mailBox,idPassword.get(0));
        log.info("Mail girildi.");
        input(passwordBox,idPassword.get(1));
        log.info("Şifre girildi");
        String loginWait=wait(login);
        click(login);
        log.info("Login olundu.");
        clickIf(notSaveMail);
        click(back);
        click(boxTrash);
        log.info("Ürün silme kutusuna basıldı");
        click(boxTrashYes);
        log.info("'Ürünü sil' sorusuna Ürünü sil denildi.");
        log.info("Test bitti.");
        List<String> data=new ArrayList<String>();
        data.add(loginWait);
        data.add(sizeValue);
        data.add(boxSizeValue);
        data.add(discountMoneyValue);
        data.add(boxDiscountMoneyValue);
        data.add(notDiscountMoneyValue);
        data.add(boxNotDiscountMoneyValue);
        return data;
    }
}
