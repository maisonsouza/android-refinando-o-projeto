package br.com.alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();
    private Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    //Indica a quantidade de elementos de um adapter
    @Override
    public int getCount() {
        return alunos.size();
    }

    //Representa o item com base em uma posição
    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    // Representa o id do elemento
    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    // Onde Criamos a View
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_aluno, parent, false);
        Aluno alunoDevolvido = alunos.get(position);
        vincula(viewCriada, alunoDevolvido);
        return viewCriada;
    }

    private void vincula(View viewCriada, Aluno aluno) {
        TextView nomeAluno = viewCriada.findViewById(R.id.textNomeAluno);
        nomeAluno.setText(aluno.getNome());
        TextView telefoneAluno = viewCriada.findViewById(R.id.textTelefoneAluno);
        telefoneAluno.setText(aluno.getTelefone());
    }


    public void update(List<Aluno> alunos) {
        this.alunos.clear();
        this.alunos.addAll(alunos);
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();
    }
}
