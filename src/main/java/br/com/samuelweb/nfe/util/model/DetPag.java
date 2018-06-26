package br.com.samuelweb.nfe.util.model;

import br.com.samuelweb.nfe.util.annotation.NfeCampo;
import br.com.samuelweb.nfe.util.consts.NfeConsts;
import br.com.samuelweb.nfe.util.enumeration.TipoPagamento;
import br.inf.portalfiscal.nfe.schema_4.enviNFe.TNFe;

import java.math.BigDecimal;

public class DetPag {

     @NfeCampo(tipo = Integer.class, id = "YA01b", tag = "indPag "
             , tamanhoMinimo = 1, tamanhoMaximo = 1, ocorrencias = 0
             , descricao = NfeConsts.DSC_INDPAG)
    private Integer indPag;

    @NfeCampo(tipo = TipoPagamento.class, id = "YA02", tag = "tPag"
            , tamanhoMinimo = 2, tamanhoMaximo = 2, ocorrencias = 1
            , descricao = NfeConsts.DSC_TPAG)
    private TipoPagamento tPag;

    @NfeCampo(tipo = BigDecimal.class, id = "YA03", tag = "vPag"
            , tamanhoMinimo = 1, tamanhoMaximo = 15, ocorrencias = 1
            , decimais = 2, precisao = 15
            , descricao = NfeConsts.DSC_VPAG)
    private BigDecimal vPag;

    @NfeCampo(tag = "card", id = "YA04", descricao = NfeConsts.DSC_CARD)
    private Card card;

    TNFe.InfNFe.Pag.DetPag build(){
        TNFe.InfNFe.Pag.DetPag detPag = new TNFe.InfNFe.Pag.DetPag();

        if (this.getIndPag() != null){
            detPag.setIndPag(this.getIndPag().toString());
        }

        detPag.setTPag(gettPag().getValue());
        if (this.getvPag() != null){
            detPag.setVPag(this.getvPag().toString());
        }
        if (this.getCard() != null) {
            detPag.setCard(this.getCard().build());
        }

        return detPag;
    }

    public Integer getIndPag() {
        return indPag;
    }

    public void setIndPag(Integer indPag) {
        this.indPag = indPag;
    }

    public TipoPagamento gettPag() {
        return tPag;
    }

    public void settPag(TipoPagamento tPag) {
        this.tPag = tPag;
    }

    public BigDecimal getvPag() {
        return vPag;
    }

    public void setvPag(BigDecimal vPag) {
        this.vPag = vPag;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
