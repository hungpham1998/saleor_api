package com.saleor.saleor_api.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "import_ticket_detail")

public class ImportTicketDetail {
    @Id
    @Column( name = "id", nullable = false, unique = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "import_price", nullable = false)
    private Long importPrice;

    @Column(name = "total_price", nullable = false)
    private Long totalPrice;

    @Column(name = "add_quantity", nullable = false)
    private Long addQuantity;

    @Column(name = "current_quantity", nullable = false)
    private Long currentQuantity;

    @Column(name = "new_quantity", nullable = false)
    private Long newQuantity;

    @Column(name = "sku", nullable = false)
    private String sku;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "importTicketDetails")
    @JsonIgnore
    private List<ImportTicket> importTickets;


    // product id

}
