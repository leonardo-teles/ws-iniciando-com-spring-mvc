$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	
	var button = $(event.relatedTarget);
	
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');

	/*
	* Estre trecho de código faz uma validação no formulário
	* para saber se a requisição termina ou não com (/{codigo})
	* a ser excluído Caso ocorra algum problema na inclusão da
    * barra(/) e do códgio({5}) a ser excluído, este trecho
	* inclui os dois valores
	*/
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if(!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoTitulo);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');
	
});