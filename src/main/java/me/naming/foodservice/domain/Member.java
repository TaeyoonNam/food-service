package me.naming.foodservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.naming.foodservice.dto.MemJoinStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

// JPA에서 @ToString 사용 시 순환 참조 문제 발생 할 수 있다. 차후 프로젝트 진행하면서 해당 내용을 좀 더 자세히 다뤄볼 것.
// 참고 : https://binarycube.tistory.com/1
@Getter
@Entity
@Table(name = "MEMBERS")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "MEM_JOIN_STATUS", nullable = false)
  private MemJoinStatus memJoinStatus;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "EMAIL", nullable = false)
  private String email;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  @Column(name = "MOBILE_NUM", nullable = false)
  private String mobileNum;

  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @CreationTimestamp
  @Column(name = "CREATE_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
  private Date createDate;

  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @UpdateTimestamp
  @Column(name = "UPDATE_DATE", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
  private Date updateAt;

//  public Member(MemJoinStatus memJoinStatus, String name, String email,  String password, String mobileNum) {
//    this.memJoinStatus = memJoinStatus;
//    this.name = name;
//    this.email = email;
//    this.mobileNum = mobileNum;
//    this.password = password;
//  }
}
