class UserService {
    private final UserRepository userRepository = new UserRepository();
    private final UserEmailService userEmailService = new UserEmailService();
    private final UserProfileRenderer userProfileRenderer = new UserProfileRenderer();
    private final UserCsvExporter userCsvExporter = new UserCsvExporter();

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public void sendWelcomeEmail(User user) {
        userEmailService.sendWelcomeEmail(user);
    }

    public void sendPasswordResetEmail(User user) {
        userEmailService.sendPasswordResetEmail(user);
    }

    public void renderUserProfile(User user) {
        userProfileRenderer.renderUserProfile(user);
    }

    public String exportUserToCsv(User user) {
        return userCsvExporter.exportUserToCsv(user);
    }
}
