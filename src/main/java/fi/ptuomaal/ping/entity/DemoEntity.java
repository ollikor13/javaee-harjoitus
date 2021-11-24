package fi.ptuomaal.ping.entity;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery
                (
                        name=DemoEntity.NAMED_QUERY_GET_ALL,
                        query="SELECT p FROM DemoEntity p"
                ),@NamedQuery
        (
                name=DemoEntity.NAMED_QUERY_FIND_BY_NAME,
                query="SELECT p FROM DemoEntity p where p.name =:name"
        )
})

public class DemoEntity {

    public static final String NAMED_QUERY_GET_ALL="N1";
    public static final String NAMED_QUERY_FIND_BY_NAME="N2";

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String name;

    public DemoEntity() {   }

    public DemoEntity (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
