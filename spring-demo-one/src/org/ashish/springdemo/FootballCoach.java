package org.ashish.springdemo;

public class FootballCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public FootballCoach() {
		System.out.println("Football :: inside no-arg constructor");
	}

	//setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Football :: inside no-arg constructor - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run 10km daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	} 
	

}
