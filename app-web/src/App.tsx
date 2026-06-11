import './App.css'
import axios from "axios";
import {useState} from "react";

interface Author {
    id: number;
    name: string;
}

interface Book {
    isbn: string;
    price: number;
    title: string;
    authors: Array<Author>;
}

function App() {

    const [authors, setAuthors] = useState<Author[]>([]);
    const [books, setBooks] = useState<Book[]>([]);

    const handleListarAutores = () => {
        axios.get<Author[]>("http://localhost/app-authors/authors")
            .then(response => {
                setAuthors(response.data);

            })
            .catch(error => alert(error));
    };

    const handleListarBooks = () => {
        axios.get<Book[]>("http://localhost/app-books/books")
            .then(response => {
                setBooks(response.data);

            })
            .catch(error => alert(error));
    };

    return (
        <>
            <section id="center">
                <div>
                    <h2>Autores</h2>
                </div>
                <button onClick={handleListarAutores}>Consultar</button>
                <br/>
                {
                    authors.map(author =>
                        <p key={author.id}>{author.id}-{author.name}</p>)
                }
            </section>

            <br/>

            <section id="center">
                <div>
                    <h2>Books</h2>
                </div>
                <button onClick={handleListarBooks}>Consultar</button>
                <br/>
                {
                    books.map(book =>
                        <ul key={book.isbn}>
                            <li>{book.isbn}-{book.title}</li>
                            {
                                book.authors.map(author =>
                                    <span key={author.id}>
                                        {author.name}
                                        <br/>
                                    </span>
                                )
                            }
                        </ul>)
                }
            </section>

        </>
    )
}

export default App
