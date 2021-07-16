package br.com.rafaelmattos.lojamattos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rafaelmattos.lojamattos.domain.Pedido;
import br.com.rafaelmattos.lojamattos.repositories.PedidoRepository;
import br.com.rafaelmattos.lojamattos.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired // instanciar o repositorio
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		//Um função que estância uma exceção (utilizou uma expressão lambda)
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}