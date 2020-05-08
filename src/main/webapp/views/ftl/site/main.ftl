<#-- @ftlvariable name="data" type="com.md.smarthouse.model.SocketData" -->
<#if data??>
    <div class="socket-data">
        <div class="socket-data-item">
            <div class="socket-data-title">Температура с датчика:</div>
            <div class="socket-data-value">${data.lastTemperatureFromSensor}</div>
        </div>
        <div class="socket-data-item">
            <div class="socket-data-title">${data.on?then('Розетка включена', 'Розетка выключена')}</div>
            <#if data.on>
                <button onclick="changeState(false)" class="button red inline">Выключить</button>
            <#else>
                <button onclick="changeState(true)" class="button inline">Включить</button>
            </#if>
        </div>
    </div>
<#else>
    <div class="text center">Нет данных</div>
</#if>

<script type="text/javascript">
    function changeState(isOn) {

        loadingIndicator.show();
        contentContainer.hide();

        let request = $.ajax({
            url: '/api/socket/user',
            type: 'PUT',
            contentType: "application/json",
            data: JSON.stringify({
                "on": isOn
            })
        });

        request.done(function (data) {
            if (data === 'OK') {
                loadContent("/", "Розетка", false);
            }
        });

        request.fail(function (data) {
            loadingIndicator.hide();
            contentContainer.show();
            showDialog('Ошибка с сервера', data);
        });
    }
</script>