package use_case.logout;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
                                userDataAccessObject = userDataAccessInterface;
                                logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {
        final String username = userDataAccessObject.getCurrentUsername();
        final LogoutOutputData outputData = new LogoutOutputData(username); 
        userDataAccessObject.setCurrentUsername(null);
        logoutPresenter.prepareSuccessView(outputData);
    }
}

