package com.produtos.ApiCaio.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.ApiCaio.Repository.ProdutoRepository;
import com.produtos.ApiCaio.models.Produto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value ="API Rest Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtorepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de Produtos.")
	public List<Produto> listaProdutos() {
		return produtorepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value ="Retorna um Produto único.")
	public Optional<Produto> listaProdutosUnico(@PathVariable(value="id")Long id) {
		return produtorepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "Este metodo Salva um produto.")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtorepository.save(produto);
		
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value= "Este metodo Deleta um produto.")
	public void deletaProduto(@RequestBody Produto produto) {
			produtorepository.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "Este metodo atualiza um produto.")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtorepository.save(produto);
	}
	
	
}
