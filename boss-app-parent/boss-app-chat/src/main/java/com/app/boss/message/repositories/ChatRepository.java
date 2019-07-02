package com.app.boss.message.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.boss.message.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, String> {
	@Query(value="select c.* from tb_chat c where c.from_user=:from limit 20", nativeQuery=true)
	List<Chat> findAllByFrom(@Param("from") String from);
	
	@Query(value="select c.* from tb_chat c where c.to_user=:to limit 20", nativeQuery=true)
	List<Chat> findAllByTo(@Param("to") String to);
	
	@Modifying
	@Query("update tb_chat set `read`=:read where from_user=:from")
	void readMsg(@Param("read") Boolean read, @Param("from") String from);
}
