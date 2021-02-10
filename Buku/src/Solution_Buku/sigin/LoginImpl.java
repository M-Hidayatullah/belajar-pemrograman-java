
package Solution_Buku.sigin;

import Solution_Buku.sigin.FormLogin;


public class LoginImpl implements LoginInterface {

    private final FormLogin login;

    public LoginImpl(FormLogin  login) {
        this.login = login;
    }

    @Override
    public void login(String username, String password) {
       login.login(username, password);
    }
}