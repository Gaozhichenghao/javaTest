package javaTestEntry;

import java.math.BigDecimal;

public class Apple {
	public Apple() {
		// TODO Auto-generated constructor stub
	}
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    static String copyright;
    
    static {
        System.out.println("初始化 copyright");
        copyright = "版权由Riot Games公司所有";
    }
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Apple [id=" + id + ", name=" + name + ", money=" + money + ", num=" + num + "]";
	}
    
}