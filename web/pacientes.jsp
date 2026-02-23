<!-- <%@page contentType="text/html" pageEncoding="UTF-8" %> -->
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-table@1.27.0/dist/bootstrap-table.min.css">
</head>
<title>medlab</title>
</head>

<body class="d-flex flex-column min-vh-100">
    <header class="d-flex border justify-content-center p-4">

    </header>
    <main class="flex-grow-1 d-flex bg-light bg-gradient">
        <div class="d-flex flex-column flex-shrink-0 p-3 border align-items-center ">
            <div class=" d-flex flex-column flex-grow-1 p-4 align-items-center ">
                <img class=" p-3" src="./assets//images//logo-anamnese.png" alt="medlab">
                <span class="p-2">Bem vindo, <strong>Convidado</strong></span>
                <a class="w-100" href="/medlab">
                    <button type="button" class="btn btn-primary w-100">Sair</button>
                </a>
            </div>
            <img class="w-50" src="./assets/images/logo-medilab.png" alt="medlab1">
        </div>

        <div class="flex-grow-1" id="example">
            <div class="bootstrap-table bootstrap5">
                <div class="fixed-table-toolbar d-flex flex-row-reverse justify-content-center">
                    <div class="float-right search btn-group">
                        <input class="form-control search-input" type="search" aria-label="Search"
                            placeholder="Filtro global" autocomplete="off">
                    </div>
                </div>

                <div class="fixed-table-container" style="padding-bottom: 0px;">
                    <div class="fixed-table-header" style="display: none;">
                        <table></table>
                    </div>
                    <div class="fixed-table-body">
                        <div class="fixed-table-loading table table-bordered table-hover" style="top: 50px;">
                            <span class="loading-wrap">
                                <span class="loading-text" style="font-size: 32px;">Carregando...</span>
                                <span class="animation-wrap"><span class="animation-dot"></span></span>
                            </span>

                        </div>
                        <table id="table" data-show-columns="true" data-pagination="true" data-search="true" data-url=""
                            class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th data-field="id">
                                        <div class="th-inner sortable both">
                                            ID Paciente
                                        </div>

                                    </th>
                                    <th data-field="name">
                                        <div class="th-inner sortable both">
                                            Paciente
                                        </div>

                                    </th>
                                    <th data-field="price">
                                        <div class="th-inner sortable both">
                                            Sexo
                                        </div>

                                    </th>
                                    <th data-field="price">
                                        <div class="th-inner sortable both">
                                            Tipo Exame
                                        </div>

                                    </th>
                                    <th data-field="price">
                                        <div class="th-inner sortable both">
                                            Modalidade
                                        </div>

                                    </th>
                                    <th data-field="price">
                                        <div class="th-inner sortable both">
                                            Data
                                        </div>

                                    </th>
                                    <th data-field="price">
                                        <div class="th-inner sortable both">
                                            Número
                                        </div>

                                    </th>
                                </tr>
                            </thead>
                            <tbody id="mytb">


                            </tbody>
                        </table>
                    </div>
                    <div class="fixed-table-footer"></div>
                </div>
                <div class="fixed-table-pagination">
                    <div class="float-right pagination">
                        <ul id="myPagination" class="pagination">

                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <script>
            const itemsPerPage = 20

            const pacientesData = JSON.parse('${pacientes}');

            let filteredData = [...pacientesData]

            let start = 0
            let end = itemsPerPage

            function getData() {
                // if (localStorage.getItem('data')) {
                //     data = JSON.parse(localStorage.getItem('data'))
                //     initTable()
                //     render()
                //     return
                // }
                // const response = await fetch('https://examples.wenzhixin.net.cn/examples/bootstrap_table/data');
                // console.log(${ pacientes }

                initTable()
                render()
            }

            function initTable() {

                const pages = Math.ceil(filteredData.length / itemsPerPage);
                document.getElementById('myPagination').innerHTML = ""
                for (let i = 1; i <= pages; i++) {
                    const pageBar = document.getElementById('myPagination')

                    const li = document.createElement("li")
                    const a = document.createElement("a")

                    li.textContent = i

                    li.className = "page-item border p-2 bg-primary bg-gradiente rounded opacity-75 nav-item"

                    li.addEventListener('click', () => changePage(i))

                    a.appendChild(li)

                    pageBar.appendChild(a)
                }
            }

            function render() {

                let table = document.getElementById("mytb")

                table.innerHTML = ""

                filteredData.slice(start, end).forEach(p => {

                    console.log(pacientesData)

                    let tr = document.createElement("tr")
                    let td = document.createElement("td")
                    let td2 = document.createElement("td")
                    let td3 = document.createElement("td")
                    let td4 = document.createElement("td")
                    let td5 = document.createElement("td")
                    let td6 = document.createElement("td")
                    let td7 = document.createElement("td")

                    td.textContent = p.id
                    td2.textContent = p.nome
                    td3.textContent = p.sexo
                    td4.textContent = p.exames.map(e => e.tipoExame)
                    td5.textContent = p.exames.map(e => e.modalidade)
                    td6.textContent = p.exames.map(e => e.dataExame)
                    td7.textContent = p.exames.map(e => e.numero)

                    tr.appendChild(td)
                    tr.appendChild(td2)
                    tr.appendChild(td3)
                    tr.appendChild(td4)
                    tr.appendChild(td5)
                    tr.appendChild(td6)
                    tr.appendChild(td7)
                    table.appendChild(tr)
                })
            }

            function changePage(page) {
                start = (page - 1) * itemsPerPage
                end = start + itemsPerPage
                render()
            }

            getData()
            const searchInput = document.querySelector('.search-input')

            searchInput.addEventListener('input', (event) => {
                const term = event.target.value.toLowerCase()

                filteredData = pacientesData.filter(p => {

                    const examesTexto = p.exames.map(e =>
                        e.tipoExame + " " +
                        e.modalidade + " " +
                        e.numero
                    ).join(" ").toLowerCase()

                    return (
                        p.id.toString().includes(term) ||
                        p.nome.toLowerCase().includes(term) ||
                        p.sexo.toLowerCase().includes(term) ||
                        examesTexto.includes(term)
                    )
                })

                start = 0
                end = itemsPerPage

                initTable()
                render()
            })
        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap-table@1.27.0/dist/bootstrap-table.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
            crossorigin="anonymous"></script>
</body>

</html>