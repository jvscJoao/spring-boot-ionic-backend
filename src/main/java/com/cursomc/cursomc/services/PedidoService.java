package com.cursomc.cursomc.services;

import java.util.Date;
import java.util.Optional;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.cursomc.domain.ItemPedido;
import com.cursomc.cursomc.domain.PagamentoComBoleto;
import com.cursomc.cursomc.domain.Pedido;
import com.cursomc.cursomc.enums.EstadoPagamento;
import com.cursomc.cursomc.exceptions.ObjectNotFoundException;
import com.cursomc.cursomc.repositories.ClienteRepository;
import com.cursomc.cursomc.repositories.ItemPedidoRepository;
import com.cursomc.cursomc.repositories.PagamentoRepository;
import com.cursomc.cursomc.repositories.PedidoRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoService produtoService;
    
    public Pedido find(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não enxontrado! ID: " + id + ", Tipo: " + Pedido.class.getName()
        ));
    }

	@Autowired
	private ClienteService clienteService;

    @Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		System.out.println(obj);
		return obj;
	}
}
