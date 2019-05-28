package contract;

public interface IBoulderDashController {

	void actionPerform(GameAction ac);
	void setView(IBoulderDashView view);
	
	void start();
}
