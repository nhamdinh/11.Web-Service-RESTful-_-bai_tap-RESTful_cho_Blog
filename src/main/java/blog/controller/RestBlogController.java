//package blog.controller;
//
//import blog.model.Blog;
//import blog.service.BlogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.List;
//
//@RestController
//public class RestBlogController {
//
//    @Autowired
//    private BlogService BlogService;
//
//
//    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
//    public ResponseEntity<List<Blog>> listAllBlogs() {
//        List<Blog> Blogs = BlogService.findAll();
//        if (Blogs.isEmpty()) {
//            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Blog>>(Blogs, HttpStatus.OK);
//    }
//
//
//    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
//        System.out.println("get blog with id " + id);
//        Blog Blog = BlogService.findById(id);
//        if (Blog == null) {
//            System.out.println("blog with id " + id + " not found");
//            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Blog>(Blog, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id) {
//        System.out.println("get & delete blog with id " + id);
//
//        Blog Blog = BlogService.findById(id);
//        if (Blog == null) {
//            System.out.println("unable to delete. blog with id " + id + " not found");
//            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
//        }
//
//        BlogService.remove(id);
//        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
//    }
//
//    @RequestMapping(value = "/blogs/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Blog> updateBlog(@PathVariable("id") int id,
//                                           @RequestBody Blog Blog) {
//        System.out.println("update blog " + id);
//
//        Blog currentBlog = BlogService.findById(id);
//
//        if (currentBlog == null) {
//            System.out.println("blog with id " + id + " not found");
//            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
//        }
//
//        currentBlog.setName(Blog.getName());
//        currentBlog.setContent(Blog.getContent());
//        currentBlog.setId(Blog.getId());
//
//        BlogService.save(currentBlog);
//        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
//    }
//
//
//
//    @RequestMapping(value = "/blogs", method = RequestMethod.POST)
//    public ResponseEntity<Void> createBlog(@RequestBody Blog Blog,
//                                           UriComponentsBuilder ucBuilder) {
//        System.out.println("create blog " + Blog.getContent());
//        BlogService.save(Blog);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/blog/{id}").buildAndExpand(Blog.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//
//
//
//}
