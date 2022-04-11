package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.rubypaper.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>  {
	List<Board> findByTitle(String searchkeyword);
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	@Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(String searchKeyword);
    @Query("SELECT b FROM Board b "
    + "WHERE b.title like %:searchKeyword%  "
 	+ "ORDER BY b.seq DESC")
     List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	@Query(value = "select seq, title, writer, create_date "
	+ "from board where title like '%'||?1||'%' "
	+ "order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest4(Pageable paging);
}