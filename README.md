Mediatheque
===========

Polytech'Nice-Sophia Advanced Database course's project using JPA and ORM.

# Database conception :

[![Database conception using ORM](http://gilles-phan.fr/partage/orm.png)](http://gilles-phan.fr/partage/orm.png)

# Some JPQL queries

_Simple named query to get the Members name and birthdate_<br/>
_[enterprise/ProjetMediatheque/entity/Adherent.java]_
```java
@NamedQuery(name = "Adherent.get", query = "SELECT a "
        + "FROM Adherent a "
        + "WHERE a.nom = :nom "
        + "AND a.prenom = :prenom "
        + "AND a.dateNaissance = :dateNaissance")
```

_Simple aggregate with join to count all Items whose Work is :work (parameter) and are available_<br/>
_[enterprise/ProjetMediatheque/entity/Reservation.java]_
```java
@NamedQuery(name = "Reservation.countAvailable", query = "SELECT count(i) "
        + "FROM Item i JOIN i.ouvrage o "
        + "WHERE o = :work "
        + "AND i.statut = enterprise.ProjetMediatheque.entity.Statut.DISPONIBLE")
```

_Another aggregate with join to get all Bookings for the specified Work :work (parameter) which are not expired_<br/>
_[enterprise/ProjetMediatheque/entity/Reservation.java]_
```java
@NamedQuery(name = "Reservation.countReservations", query = "SELECT count(r) "
    + "FROM Reservation r JOIN r.ouvrage o "
    + "WHERE o = :work "
    + "AND r.dateDExpiration IS NOT NULL "
    + "AND r.dateDExpiration < :date")
```

#### About getting the Works objects
In order to get all the Works objects, we use a simple select query in [servlet/ListWorksServlet.java] :
```java
SELECT o FROM Ouvrage o
```

We could have used a join fetch query if we had used FetchType.EAGER for our ManyToMany relationships in [entity/Ouvrage.java] :
```java
SELECT o FROM Ouvrage o JOIN FETCH o.genres JOIN FETCH o.auteurs
```

This way, we can fetch Genres and Authors only when we need them.