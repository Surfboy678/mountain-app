package com.mountainapp.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "mountains")
public class Mountain {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "mountain_name", nullable = false, unique = true)
   private String mountainName;

   @Column(name = "mountain_range")
   private String mountainRange;

   @Column(name = "muntain_type")
   private String mountainType;

   @Column(name = "lenght_of_the_mountain_range")
   private long lengthOfTheMountainRange;

   @Column(name = "height_above_sea_level")
   private long heightAboveSeaLevel;

   @Column(name = "mountain_image")
   private String mountainImage;


}
