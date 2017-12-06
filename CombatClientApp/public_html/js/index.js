(function () {

    function buildCombatResultTable(results) {
        var table = document.createElement('table');
        for (var i = 0; i < results.combatLog.length; i++) {

            // Round title
            var tr = document.createElement('tr');
            tr.setAttribute("class", "round-title");

            var tdTitle = document.createElement('td');
            tdTitle.setAttribute("colspan", 5);

            tdTitle.appendChild(document.createTextNode("Round " + (i + 1)));

            tr.appendChild(tdTitle);

            // Titles
            var trt = document.createElement('tr');
            trt.setAttribute("class", "title");

            var tdName = document.createElement('td');
            var tdType = document.createElement('td');
            var tdHP = document.createElement('td');
            var tdSkill = document.createElement('td');
            var tdHPDelta = document.createElement('td');

            tdName.appendChild(document.createTextNode("Name"));
            tdType.appendChild(document.createTextNode("Role"));
            tdHP.appendChild(document.createTextNode("HP"));
            tdSkill.appendChild(document.createTextNode("Used skill"));
            tdHPDelta.appendChild(document.createTextNode("Delta HP"));

            trt.appendChild(tdName);
            trt.appendChild(tdType);
            trt.appendChild(tdHP);
            trt.appendChild(tdSkill);
            trt.appendChild(tdHPDelta);

            // PROTAGONIST
            var tr1 = document.createElement('tr');

            var ptdName = document.createElement('td');
            var ptdType = document.createElement('td');
            var ptdHP = document.createElement('td');
            var ptdSkill = document.createElement('td');
            var ptdHPDelta = document.createElement('td');

            ptdName.appendChild(document.createTextNode(results.combatLog[i].protagonist.name));
            ptdType.appendChild(document.createTextNode("PROTAGONIST"));
            ptdHP.appendChild(document.createTextNode(results.combatLog[i].proHitPoints));
            ptdSkill.appendChild(document.createTextNode(results.combatLog[i].proSkill.name));
            ptdHPDelta.appendChild(document.createTextNode(results.combatLog[i].proHitPointDelta));

            tr1.appendChild(ptdName);
            tr1.appendChild(ptdType);
            tr1.appendChild(ptdHP);
            tr1.appendChild(ptdSkill);
            tr1.appendChild(ptdHPDelta);

            // ANTAGONIST
            var tr2 = document.createElement('tr');

            var atdName = document.createElement('td');
            var atdType = document.createElement('td');
            var atdHP = document.createElement('td');
            var atdSkill = document.createElement('td');
            var atdHPDelta = document.createElement('td');

            atdName.appendChild(document.createTextNode(results.combatLog[i].antagonist.name));
            atdType.appendChild(document.createTextNode("ANTAGONIST"));
            atdHP.appendChild(document.createTextNode(results.combatLog[i].antaHitPoints));
            atdSkill.appendChild(document.createTextNode(results.combatLog[i].antaSkill.name));
            atdHPDelta.appendChild(document.createTextNode(results.combatLog[i].antaHitPointDelta));

            tr2.appendChild(atdName);
            tr2.appendChild(atdType);
            tr2.appendChild(atdHP);
            tr2.appendChild(atdSkill);
            tr2.appendChild(atdHPDelta);

            // tr to table
            table.appendChild(tr);
            table.appendChild(trt);
            table.appendChild(tr1);
            table.appendChild(tr2);
        }
        document.getElementById("conbatResultTable").innerHTML = "";
        document.getElementById("location").innerHTML = "";
        document.getElementById("winnerName").innerHTML = "";
        document.getElementById("winnerDesc").innerHTML = "";
        document.getElementById("heroDeaths").innerHTML = "";

        document.getElementById("conbatResultTable").appendChild(table);
        document.getElementById("location").innerHTML = results.location.name + ", " + results.location.description;
        document.getElementById("winnerName").innerHTML = results.winner.name;
        document.getElementById("winnerDesc").innerHTML = results.winner.description;
        for (var i = 0; i < results.deaths.length; i++) {
            if (i !== 0)
                document.getElementById("heroDeaths").innerHTML += ", ";
            document.getElementById("heroDeaths").innerHTML += results.deaths[i].name;
        }
    }

    function loadData() {
        buildCombatResultTable(this.response);
    }

    function RebuildTable() {
        GetCombatJSON(document.getElementById("heroId").value, document.getElementById("locationId").value, 
            function (response) {
                buildCombatResultTable(response);
        });
    }

    function GetCombatJSON(heroId, locationId, callback) {
        callback = (typeof callback !== 'undefined') ? callback : function () {};
        var oReq = new XMLHttpRequest();
        oReq.responseType = "json";
        oReq.addEventListener("load", loadData);
        oReq.open("GET", "http://212.237.28.207:8080/myapp/combat/" + heroId + "/" + locationId);
        oReq.send();
        oReq.onreadystatechange = function () {
            if (this.readyState == 4 && this.status == 200) {
                callback(oReq.response);
            }
        };
    }

    GetCombatJSON(1, 1);
    document.getElementById("fightBtn").onclick = function () {
        RebuildTable();
    };

})();