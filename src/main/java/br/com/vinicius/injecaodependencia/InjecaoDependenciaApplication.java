package br.com.vinicius.injecaodependencia;

import br.com.vinicius.injecaodependencia.entity.Order;
import br.com.vinicius.injecaodependencia.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class InjecaoDependenciaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InjecaoDependenciaApplication.class, args);
	}

	@Autowired
	OrderService orderService;

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.printf("Pedido código: %d%n", order.getCode());
		System.out.printf("Valor total: R$ %.2f%n",orderService.total(order));

		sc.close();
	}
}
