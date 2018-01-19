import com.globant.appium.AppiumConfig;
import com.globant.config.ConfigApplication;
import com.globant.model.User;
import com.globant.util.MapperJSON;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Test {

    public static void main(String[] arg) {
        /*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ConfigApplication.class);
        ctx.refresh();


        AppiumConfig myBeanOne = (AppiumConfig) ctx.getBean("appiumConfig");

        System.out.println(myBeanOne.platformVersion());
        System.out.println(myBeanOne.isRunEnviroment());

        DesiredCapabilities myBean = (DesiredCapabilities) ctx.getBean("desiredCapabilities");

        System.out.println(myBean.getPlatform());*/

        try {
            for (User user: MapperJSON.getObjects(User.class, "Users.json")) {
                System.out.println(user.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
