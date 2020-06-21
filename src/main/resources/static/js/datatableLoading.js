$(document).ready(function() {
    $('#datatable').DataTable({
        "paging": false,
        "info": false,
        "searching": false,
        "ordering": false,
        "language": {
            "emptyTable":     "Aucune donnée trouvée.",
            "info":           "_START_ données récupérées sur _END_ d'un total de _TOTAL_ entrées",
            "infoEmpty":      "Aucune donnée récupérée",
            "infoFiltered":   "(filtré de _MAX_ entrées au total)",
            "infoPostFix":    "",
            "thousands":      ",",
            "lengthMenu":     "Afficher _MENU_ entrées uniquement",
            "loadingRecords": "Chargement...",
            "processing":     "Traitement...",
            "search":         "Rechercher:",
            "zeroRecords":    "Aucun enregistrement correspondant",
            "paginate": {
                "first":      "Première",
                "last":       "Dernière",
                "next":       "Suivante",
                "previous":   "Précedante"
            },
            "aria": {
                "sortAscending":  ": activer le tri ascendant",
                "sortDescending": ": activer le tri descendant"
            }
        }
    });
} );