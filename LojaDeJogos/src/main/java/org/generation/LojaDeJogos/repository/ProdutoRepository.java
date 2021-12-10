package org.generation.LojaDeJogos.repository;

import java.math.BigDecimal;
import java.util.List;

import org.generation.LojaDeJogos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	/**
	 *  Método Personalizado - Buscar todos os Produtos cujo o preço seja maior 
	 *  do que um valor digitado ordenado pelo preço em ordem crescente
	 *  
	 *  MySQL: select * from tb_produtos where preco > preco order by preco;
	 */
	public List <Produto> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);	
	/**
	 *  Método Personalizado - Buscar todos os Produtos cujo o preço seja menor 
	 *  do que um valor digitado ordenado pelo preço em ordem decrescente
	 *  
	 *  MySQL: select * from tb_produtos where preco < preco order by preco desc;
	 */	 
	public List <Produto> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);
}
