package com.atinagnihotri.bookheads;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.atinagnihotri.bookheads.Adapters.ListBooksRecViewAdapter;
import com.atinagnihotri.bookheads.DTO.BookDTO;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {

    private RecyclerView listBooksRecyclerView;
    private ListBooksRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        initViews();
        initAdapter();
        setBooksStub();
    }

    private void initViews(){
        listBooksRecyclerView = findViewById(R.id.listBooksRecyclerView);
    }

    private void initAdapter(){
        adapter = new ListBooksRecViewAdapter(this);
        listBooksRecyclerView.setAdapter(adapter);
        listBooksRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void setBooksStub(){
        ArrayList<BookDTO> books = new ArrayList<>();

        books.add(new BookDTO(1,
                "Demon Haunted World",
                "Carl Sagan",
                180,
                "https://images-na.ssl-images-amazon.com/images/I/516v2EY3F8L._SX335_BO1,204,203,200_.jpg",
                "Science as a candle in the dark",
                "It's a book about science and rationality written by Carl Sagan to combat what he saw as backslide in" +
                        " critical and scientific thinking skills amongst the broader culture and what roles major establishments" +
                        "of US life were playing."));
        books.add(new BookDTO(2,
                "Accessory to War",
                "Niel DeGrasse Tyson",
                280,
                "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fkbimages1-a.akamaihd.net%2F7b82c75f-4b79-430c-933c-70f2a833e843%2F1200%2F1200%2FFalse%2Faccessory-to-war-the-unspoken-alliance-between-astrophysics-and-the-military.jpg",
                "The unspoken alliance between astrophysics and military",
                "Accessory to War: The Unspoken Alliance Between Astrophysics and the Military is the fifteenth book by" +
                        " American astrophysicist and science communicator Neil deGrasse Tyson which he co-wrote with researcher" +
                        " and writer Avis Lang. It was released on September 11, 2018 by W. W. Norton & Company. The book" +
                        " chronicles war and the use of space as a weapon, including Christopher Columbus use of his knowledge of a" +
                        " lunar eclipse and the use of satellite intelligence by the United States during the Gulf War"));
        books.add(new BookDTO(3,
                "Zhukov's Greatest Defeat",
                "David M. Glantz",
                319,
                "https://images-na.ssl-images-amazon.com/images/I/51YDfaabq4L._SX328_BO1,204,203,200_.jpg",
                "The Red Army's epic disaster in Operation Mars, 1942",
                "One of the least known stories of World War II, Operation Mars was a military disaster on an epic scale." +
                        " Designed to dislodge the German Army from its position west of Moscow, Mars cost the Soviets an estimated" +
                        " 335,000 dead, missing, and wounded men and over 1,600 tanks. But in Russian history books, it was a battle" +
                        " that never happened. It became instead another victim of Stalin's postwar censorship."));
        books.add(new BookDTO(4,
                "Manufacturing Consent",
                "Edward S. Herman and Noam Chomsky",
                473,
                "https://upload.wikimedia.org/wikipedia/en/c/ce/Manugactorinconsent2.jpg",
                "The Political Economy of the Mass Media",
                "Manufacturing Consent: The Political Economy of the Mass Media is a 1988 book by Edward S. Herman and" +
                        " Noam Chomsky, in which the authors propose that the mass communication media of the U.S. \"are " +
                        "effective and powerful ideological institutions that carry out a system-supportive propaganda function" +
                        ", by reliance on market forces, internalized assumptions, and self-censorship, and without overt " +
                        "coercion\", by means of the propaganda model of communication. The title derives from the phrase \"" +
                        "the manufacture of consent\", employed in the book Public Opinion (1922) by Walter Lippmann (1889–1974)" +
                        ". The consent referred to is consent of the governed."));
        books.add(new BookDTO(5,
                "Critique of Pure Reason",
                "Immanuel Kant",
                180,
                "https://upload.wikimedia.org/wikipedia/commons/b/b9/Kant-KdrV-1781.png",
                "Kritik der reinen Vernunft",
                "The Critique of Pure Reason (German: Kritik der reinen Vernunft; 1781; second edition 1787) is a book" +
                        " by the German philosopher Immanuel Kant, in which the author seeks to determine the limits and scope " +
                        "of metaphysics. Also referred to as Kant's \"First Critique\", it was followed by the Critique of " +
                        "Practical Reason (1788) and the Critique of Judgment (1790). In the preface to the first edition, Kant " +
                        "explains that by a \"critique of pure reason\" he means a critique \"of the faculty of reason in general" +
                        ", in respect of all knowledge after which it may strive independently of all experience\" and that he" +
                        " aims to reach a decision about \"the possibility or impossibility of metaphysics.\""));
        books.add(new BookDTO(6,
                "A Brief History of Time",
                "Stephen Hawking",
                180,
                "https://upload.wikimedia.org/wikipedia/en/a/a3/BriefHistoryTime.jpg",
                "From the Big Bang to Black Holes",
                "A Brief History of Time: From the Big Bang to Black Holes is a popular-science book on cosmology" +
                        " by English physicist Stephen Hawking.[1] It was first published in 1988. Hawking wrote the book " +
                        "for readers without prior knowledge of the universe and people who are just interested in learning" +
                        " something new."));

        adapter.setBooks(books);
    }
}