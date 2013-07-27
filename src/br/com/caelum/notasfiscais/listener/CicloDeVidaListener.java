package br.com.caelum.notasfiscais.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CicloDeVidaListener implements PhaseListener {

	private static final long serialVersionUID = 3763189288001459870L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.printf("Depois da fase: %s\n", event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.printf("Antes da fase: %s\n", event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
