import edu.educom.simplechat.client.controller.ClientController;
import edu.educom.simplechat.client.gui.ClientView;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Mingi-Seo on 2014-12-04.
 */
public class ClientTest {
    @Test
    public void testClient() {
        ClientView clientView = new ClientView();
        ClientController controller = new ClientController("203.253.207.123", clientView);
        clientView.show();
        assertThat(clientView.isVisable(), is(true));
    }


}
