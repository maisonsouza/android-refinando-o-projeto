package br.com.alura.agenda.ui.adapter;

import android.annotation.SuppressLint;
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
    private final Context context;

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
    public Object getItem(int position) {
        return alunos.get(position);
    }

    // Representa o id do elemento
    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder") View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_aluno, parent, false);
        Aluno alunoDevolvido = alunos.get(position);
        TextView nomeAluno = viewCriada.findViewById(R.id.textNome);
        TextView telefoneAluno = viewCriada.findViewById(R.id.textTelefone);
        nomeAluno.setText(alunoDevolvido.getNome());
        telefoneAluno.setText(alunoDevolvido.getTelefone());
        return viewCriada;
    }

    public void clear() {
        alunos.clear();
    }

    public void addAll(List<Aluno> todos) {
        alunos.addAll(todos);
    }

    public void remove(final Aluno aluno) {
        alunos.remove(aluno);
        notifyDataSetChanged();

    }
}
