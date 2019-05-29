package contract;

public interface IBoulderDashView {

	void addKeyCorrespondance(int keycode, GameAction action);

	GameAction keyCodeToAction(int keycode);

	void initialize();

	void refresh();

}
