package org.ashish.springdemo;

public class FootballCoach implements Coach{
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Football :: inside no-arg constructor - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Football :: inside no-arg constructor - setTeam");
		this.team = team;
	}

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
