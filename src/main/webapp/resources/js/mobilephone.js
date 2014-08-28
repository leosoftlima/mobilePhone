function mascara(o, f) {
    v_obj = o;
    v_fun = f;
    setTimeout("execmascara()", 1);
}

function execmascara() {
    v_obj.value = v_fun(v_obj.value);
}

function valor(v) {
    v = v.replace(/\D/g, "");
    v = v.replace(/[0-9]{15}/, "inválido");
    v = v.replace(/(\d{1})(\d{11})$/, "$1.$2"); // coloca ponto antes dos ultimos 11 digitos
    v = v.replace(/(\d{1})(\d{8})$/, "$1.$2"); // coloca ponto antes dos ultimos 8 digitos
    v = v.replace(/(\d{1})(\d{3})$/, "$1.$2"); // coloca ponto antes dos ultimos 5 digitos
    return v;
}

PrimeFaces.locales['pt'] = {
        closeText: 'Fechar',
        prevText: 'Anterior',
        nextText: 'Pr&#243;ximo',
        currentText: 'Come&#231;o',
        monthNames: ['Janeiro','Fevereiro','Mar&#231;o','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun', 'Jul','Ago','Set','Out','Nov','Dez'],
        dayNames: ['Domingo','Segunda','Ter&#231;a','Quarta','Quinta','Sexta','S&#225;bado'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','SÃ¡b'],
        dayNamesMin: ['D','S','T','Q','Q','S','S'],
        weekHeader: 'Semana',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        timeOnlyTitle: 'S&#243; Horas',
        timeText: 'Tempo',
        hourText: 'Hora',
        minuteText: 'Minuto',
        secondText: 'Segundo',
        currentText: 'Data Atual',
        ampm: false,
today: 'Hoje',
        month: 'M&#234;s',
        week: 'Semana',
        day: 'Dia',
        allDayText : 'Todo Dia'
    };