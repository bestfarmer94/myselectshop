package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByUserId(Long userId, Pageable pageable);
    Optional<Product> findByIdAndUserId(Long id, Long userId);
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByUserIdAndFolderList_Id(Long userId, Long folderId, Pageable pageable);

    // Folderlist_id : Folderlist 리스트 내의 객체의 id 컬럼을 읽는 것 같다. _의 역할을 기억하자.
    Optional<Product> findByIdAndFolderList_Id(Long productId, Long folderId);
}