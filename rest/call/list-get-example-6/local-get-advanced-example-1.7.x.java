// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.rest.Twilio;
import com.twilio.rest.creator.api.v2010.account.incomingphonenumber.LocalCreator;
import com.twilio.rest.reader.api.v2010.account.availablephonenumbercountry.LocalReader;
import com.twilio.rest.resource.ResourceSet;
import com.twilio.rest.resource.api.v2010.account.availablephonenumbercountry.Local;
import com.twilio.rest.type.PhoneNumber;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
  public static final String AUTH_TOKEN = "your_auth_token";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    ResourceSet<Local> numbers = new LocalReader("US").byAreaCode(619).byContains("555").execute();
    PhoneNumber availableNumber = numbers.iterator().next().getPhoneNumber();

    new LocalCreator(availableNumber).execute();
  }
}