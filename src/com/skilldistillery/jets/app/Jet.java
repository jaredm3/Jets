package com.skilldistillery.jets.app;

public abstract class Jet {

	// F I E L D S
	private String model;
	private double speed;
	private int range;
	private long price;
	private double timeAloft;

	// C O N S T R U C T O R
	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// M E T H O D S
	public abstract void fly();

	public double getSpeedInMach() {
		return (this.getSpeed() / 767);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [Model=");
		builder.append(model);
		builder.append(", Speed=");
		builder.append(speed + "mph");
		builder.append(", Range=");
		builder.append(range + "mi");
		builder.append(", Price=$");
		builder.append(price);
		builder.append("]");
		return builder.toString();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public double getTimeAloft() {
		return timeAloft;
	}

	public void setTimeAloft(double timeAloft) {
		this.timeAloft = timeAloft;
	}

}
