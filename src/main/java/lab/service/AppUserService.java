package lab.service;

import lab.model.AppUser;
import java.util.List;

public interface AppUserService {
    List<AppUser> getAppUsers();

    AppUser addAppUser(AppUser appUser);

    AppUser findUserByEmail(String email);
}
