package br.com.eletronicsManager.api.microprocessador;

import br.com.eletronicsManager.api.fabricante.Fabricante;
import br.com.eletronicsManager.api.projeto.Projeto;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author aula
 */
@Entity
@Table(name = "microprocessadores", schema = "public")
public class Microprocessador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(nullable = false)
    private String codFabricante;

    @Column(nullable = false)
    private double preco;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Column(nullable = false)
    private String arquitetura;

    @ManyToOne
    @JoinColumn(name = "fabricante")
    private Fabricante fabricante;

    @OneToMany(mappedBy = "microprocessador", targetEntity = Projeto.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Projeto> projetos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodFabricante() {
        return codFabricante;
    }

    public void setCodFabricante(String codFabricante) {
        this.codFabricante = codFabricante;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getDatalancamento() {
        return dataLancamento;
    }

    public void setDatalancamento(LocalDate datalancamento) {
        this.dataLancamento = datalancamento;
    }

    public String getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
        this.arquitetura = arquitetura;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public List<Projeto> getProjetos() {
        return this.projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

}
